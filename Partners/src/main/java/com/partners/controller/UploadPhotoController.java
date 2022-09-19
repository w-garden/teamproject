package com.partners.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.controller.Action;
import com.partners.controller.ActionForward;

public class UploadPhotoController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./portfolio/p_upload_photo.jsp");
		return forward;
	}

}
