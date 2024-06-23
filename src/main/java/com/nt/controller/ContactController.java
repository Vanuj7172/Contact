package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Contact;
import com.nt.service.ContactService;
import com.nt.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	

//	------------------------------------------------------

	
	
	@RequestMapping(value="/user/contact_form")
	public String contactForm(Model m) {
		Contact contact = new Contact();
		m.addAttribute("command",contact);
		return "contact_form";
		
	}
	
	
	//----------------------------------------------------------------
	
	
	@RequestMapping(value="/user/clist")
	public String  contactList(Model m , HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		m.addAttribute("contactList", contactService.findUserContact(userId));
		
		return "clist";
		
	}
	
	
	
	
	//----------------------------------------------------------------
	
	
		@RequestMapping(value="/user/contact_search")
		public String  contactSearch(Model m , HttpSession session ,@RequestParam("freeText") String freeText) {
			Integer userId = (Integer) session.getAttribute("userId");
			
			m.addAttribute("contactList", contactService.findUserContact(userId,freeText));
			
			return "clist";
			
		}
	
	
//	--------------------------------------------------------------------
	
	@RequestMapping(value="/user/del_contact")
	public String  deleteContact(@RequestParam("cid") Integer contactId) {

		contactService.delete(contactId);
		
		return "redirect:clist?act=del";
		
	}
	
	
	
//	--------------------------------------------------------------------
	
	@RequestMapping(value="/user/bulk_cdelete")
	public String  deleteBlukContact(@RequestParam("cid") Integer[] contactIds) {

		contactService.delete(contactIds);
		
		return "redirect:clist?act=del";
		
	}
	
	
	//-------------------------------------------------------------------------
	
	@RequestMapping(value="/user/edit_contact")
	public String  prepareEditForm(@RequestParam("cid") Integer contactId , HttpSession session , Model m) {

		session.setAttribute("aContactId",contactId);
		Contact c = contactService.findbyId(contactId);
		
		m.addAttribute("command",c);
		
		return "contact_form";
	}
	
	
	
	
	
//	----------------------------------------------------------------------------------------
	
	
	@RequestMapping(value="/user/save_contact")
	public String saveorupdateContact(@ModelAttribute("command") Contact c,Model m , HttpSession session) {
		
		Integer contactId = (Integer) session.getAttribute("aContactId");
		
		if(contactId == null){
			//save task

			try {
			Integer userId = (Integer) session.getAttribute("userId");
			c.setUserId(userId);
			
			contactService.save(c);
		
			return "redirect:clist?act=sv";
			}
			
			catch(Exception e) {
				e.printStackTrace();
				m.addAttribute("error","Failed to save contact");
				return "contact_form";
				
			}
				
			
		}else { 
			
			//update task

			try {
			c.setContactId(contactId); //PK
			contactService.update(c);
			return "redirect:clist?act=ed";
			}
			
			catch(Exception e) {
				e.printStackTrace();
				m.addAttribute("error","Failed to update contact");
				return "contact_form";
				
			}
			
		}
		
		
	}
	
//	-------------------------------------------------------------------------------

}
