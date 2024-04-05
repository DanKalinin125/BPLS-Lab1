package com.example.bplslab1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDTO {
    private String username;
    private String email;
    private String text;

    public boolean check() {
        if (username == null || username.isEmpty()) return false;
        if (email == null || email.isEmpty()) return false;
        if (text == null || text.isEmpty()) return false;
        return true;
    }
}
