import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
    @SerializedName("firtName")
    private String firtName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("age")
    private int age;

    public Person(String firtName, String lastName, int age) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firtName", firtName)
                .append(" lastName", lastName)
                .append(" age", age).toString();
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
