package poly.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.dao.FavoriteDAO;
import poly.dao.VideoDAO;
import poly.model.Favorite;
import poly.model.User;
import poly.model.Video;

/**
 * Servlet implementation class detail
 */
@WebServlet("/admin/detail")
public class DetailVideoManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		String videoId = request.getParameter("videoId");
		VideoDAO dao = new VideoDAO();
		Video video = dao.findById(videoId);
		if (username != null) {
			FavoriteDAO favdao = new FavoriteDAO();
			Favorite fav = favdao.findOneByUserIdAndVideoId(username, videoId);
			request.setAttribute("favorite", fav);
			request.setAttribute("username", username);
		} else {
			request.getRequestDispatcher("/login").forward(request, response);
			return;
		}
		request.setAttribute("video", video);
		PageInfo.prepareAndForward(request, response, PageType.DETAIL_VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
