package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDao;

/**
 * Servlet implementation class DaoSampleController
 */
@WebServlet("/DaoSample")
public class DaoSample extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DaoSample() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao userDao = new UserDao();

			List<UserBean> userList = userDao.findAll();

			request.setAttribute("userList", userList);

			request.getRequestDispatcher("/WEB-INF/jsp/daoSample.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			UserDao userDao = new UserDao();

			List<UserBean> userList = userDao.searchUser(
				request.getParameter("login_id"),
				request.getParameter("name"),
				request.getParameter("birth_date_from"),
				request.getParameter("birth_date_to")
			);

			request.setAttribute("userList", userList);

			request.getRequestDispatcher("/WEB-INF/jsp/daoSample.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
