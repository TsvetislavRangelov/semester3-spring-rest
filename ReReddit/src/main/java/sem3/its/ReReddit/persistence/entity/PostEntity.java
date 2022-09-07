package sem3.its.ReReddit.persistence.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostEntity {
    private Long id;
    private String author;
    private String header;
    private String body;
    private int ups;
    private int downs;
    private String[] comments;
}
