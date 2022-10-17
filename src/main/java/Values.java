import java.util.Arrays;

public class Values {
    private String title;
    private String text;
    public Values() {}
    public Values(String value1, String value2) {
        this.title = value1;
        this.text = value2;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "Title: " + title + ", Text: " + text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Values values)) {
            return false;
        }

        String title = values.getTitle(), text = values.getText();
        if (this.title == null) return title == null;
        if (this.text == null) return text == null;
        return values.getTitle().equals(title) && values.getText().equals(text);
    }
}
