package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JSTLのタグライブラリ使用例です。
 */
@WebServlet("/JstlSample")
public class JstlSample extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlSample() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 条件分岐用
			String sample = "sample";
			request.setAttribute("sample", sample);

			// 繰り返し用
			ArrayList<String> sampleList = new ArrayList<String>();
			sampleList.add("1番目");
			sampleList.add("2番目");
			sampleList.add("3番目");
			sampleList.add("4番目");
			request.setAttribute("sampleList", sampleList);

			request.getRequestDispatcher("/WEB-INF/jsp/jstl.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
