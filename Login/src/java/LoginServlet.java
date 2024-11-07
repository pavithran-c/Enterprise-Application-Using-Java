import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Database connection parameters
            String jdbcUrl = "jdbc:mysql://localhost:3306/user_db?serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL";
            String dbUser = "root";  // replace with your database username
            String dbPassword = "06456943";  // replace with your database password

            // Declare resources
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection
                conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

                // Prepare SQL query
                String sql = "SELECT password FROM users WHERE username = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);

                // Execute the query
                rs = stmt.executeQuery();

                if (rs.next()) {
                    String storedPasswordHash = rs.getString("password");

                    // Verify password (implement your verification logic here)
                    if (verifyPassword(password, storedPasswordHash)) {
                        // Login success
                        response.sendRedirect("login.jsp");
                    } else {
                        // Login failed
                        response.sendRedirect("welcome.jsp?error=1");
                    }
                } else {
                    // Username not found
                    response.sendRedirect("welcome.jsp?error=1");
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log this properly in production
                response.sendRedirect("welcome.jsp?error=2");
            } catch (ClassNotFoundException e) {
                e.printStackTrace(); // Handle driver not found
                response.sendRedirect("welcome.jsp?error=3");
            } finally {
                // Close resources
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Log the exception here if needed
                }
            }
        }
    }

    private boolean verifyPassword(String password, String storedPasswordHash) {
        // Implement password hashing verification logic here
        return password.equals(storedPasswordHash); // Replace with actual verification
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
