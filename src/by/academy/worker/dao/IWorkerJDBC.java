package by.academy.worker.dao;

import java.util.List;

import by.academy.worker.entities.Worker;

/**
 * Interface IWorkerJDBC
 *
 */

public interface IWorkerJDBC {

	public void create(Worker worker);

	public Worker read(int messageId);

	public void update(Worker worker);

	public void delete(int messageId);

	public List<Worker> showAll();

}
