
package org.aadsp.interfaces;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/** Classe base de um bean, promove a serialização o mesmo
 */
public abstract class ABaseNamed implements Serializable {

    private static final long serialVersionUID = 201402181252L;

    @Override
    public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
            return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        return hash;
    }

}

