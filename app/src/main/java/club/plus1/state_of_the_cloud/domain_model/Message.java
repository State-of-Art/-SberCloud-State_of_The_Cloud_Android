package club.plus1.state_of_the_cloud.domain_model;

public class Message {
    public String text;
    public Boolean direction;

    public Message(String text, Boolean direction) {
        this.text = text;
        this.direction = direction;
    }
}
