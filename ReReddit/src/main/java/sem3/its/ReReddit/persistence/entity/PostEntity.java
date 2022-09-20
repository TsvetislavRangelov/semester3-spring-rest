package sem3.its.ReReddit.persistence.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostEntity {
    private Long id;
    private UserEntity author;
    private String header;
    private String body;
    private int ups;
    private int downs;
    private int comments;

}
