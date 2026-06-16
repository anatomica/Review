package ATM;

import java.util.List;

interface ITaskService {
    Task create(Task task);

    Task getById(Long id);

    List<Task> getAll();

    Task update(Long id, Task task);

    Task delete(Long id);
}
