package poly.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.dao.FavoriteDAO;
import poly.dao.ShareDAO;
import poly.dao.VideoDAO;
import poly.domain.FavoriteReport;
import poly.domain.ReportUser;
import poly.domain.ReportUserShare;
import poly.model.Video;

/**
 * Servlet implementation class ReportsManagementServlet
 */
@WebServlet("/admin/reports")
public class ReportsManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reportByVideos(request, response);
		reportUsersByVideo(request, response);
		reportSharesByVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void reportByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDAO dao = new FavoriteDAO();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();
			request.setAttribute("favList", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void reportUsersByVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoUserId = request.getParameter("videoUserId");
			VideoDAO vdao = new VideoDAO();
			List<Video> vlist = vdao.findAll();
			if (videoUserId == null && vlist.size() > 0) {
				videoUserId = vlist.get(0).getId();
			}
			FavoriteDAO dao = new FavoriteDAO();
			List<ReportUser> list = dao.reportUsersByVideo(videoUserId);
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("vidList", vlist);
			request.setAttribute("favUsers", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void reportSharesByVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoUserId = request.getParameter("videoUserId");
			VideoDAO vdao = new VideoDAO();
			List<Video> vlist = vdao.findAll();

			if (videoUserId == null && vlist.size() > 0) {
				videoUserId = vlist.get(0).getId();
			}
			ShareDAO dao = new ShareDAO();
			List<ReportUserShare> list = dao.reportSharesVideo(videoUserId);
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("vidList", vlist);
			request.setAttribute("shares", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
