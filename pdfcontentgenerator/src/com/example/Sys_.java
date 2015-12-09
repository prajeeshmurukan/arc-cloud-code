
package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Sys_ {

    @SerializedName("pod")
    @Expose
    private String pod;

    /**
     * 
     * @return
     *     The pod
     */
    public String getPod() {
        return pod;
    }

    /**
     * 
     * @param pod
     *     The pod
     */
    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pod).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sys_) == false) {
            return false;
        }
        Sys_ rhs = ((Sys_) other);
        return new EqualsBuilder().append(pod, rhs.pod).isEquals();
    }

}
