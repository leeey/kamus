package project.camus.feign.task.api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import project.camus.feign.task.domain.dto.TaskDto;
import project.camus.feign.task.domain.enums.TaskPriorityType;

@Service
public class TaskDummyService {

    public List<TaskDto> findTasksByMemberId(Long memberId) {

        return List.of(
            TaskDto.builder()
                .id(1L)
                .memberId(memberId)
                .description("Blah Blah")
                .priority(TaskPriorityType.HIGH)
                .build(),
            TaskDto.builder()
                .id(2L)
                .memberId(memberId)
                .description("Blah Blah Blah")
                .priority(TaskPriorityType.LOW)
                .build()
        );
    }
}
