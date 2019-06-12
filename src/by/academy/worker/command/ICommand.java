package by.academy.worker.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface ICommand
 *
 */

public interface ICommand {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
