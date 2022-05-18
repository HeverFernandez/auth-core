package edu.epis.sisga.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by AITAMH on 2/10/2020.
 */
public class SendEmail {

    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    @Size(min = 6, max = 100)
    private String mail;

    @Size(min = 3, max = 200)
    private String subject;

    @NotBlank
    @Size(min = 6, max = 500)
    private String body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
