package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class TaskService implements ITaskService {

    private final Map<Long, Task> data = new ConcurrentHashMap<>();
    private final AtomicLong idSequence = new AtomicLong(1);

    @Override
    public Task create(Task task) {
        return Optional.ofNullable(task)
                .map(t -> {
                    if (t.id == null) {
                        t.id = idSequence.getAndIncrement();
                    }
                    data.put(t.id, t);
                    return t;
                })
                .orElseGet(() -> {
                    Task newTask = new Task();
                    newTask.id = idSequence.getAndIncrement();
                    data.put(newTask.id, newTask);
                    return newTask;
                });
    }

    @Override
    public Task getById(Long id) {
        return Optional.ofNullable(data.get(id))
                .orElseThrow(() -> new RuntimeException(String.format("ATM.Task with id %s not found", id)));
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Task update(Long id, Task task) {
        Task taskForUpd = Optional.ofNullable(data.get(id))
                .orElseThrow(() -> new RuntimeException(String.format("ATM.Task with id %s not found", id)));

        taskForUpd.title = task.title;
        taskForUpd.status = task.status;

        data.put(id, taskForUpd);

        return taskForUpd;
    }

    @Override
    public Task delete(Long id) {
        return Optional.ofNullable(data.remove(id))
                .orElseThrow(() -> new RuntimeException(String.format("ATM.Task with id %s not found", id)));
    }
}
