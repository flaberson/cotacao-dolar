package br.com.flaberson.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoDiaResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Set<CotacaoResponse> value = Set.of();

    public CotacaoDiaResponse() {}

    public CotacaoDiaResponse(Set<CotacaoResponse> value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CotacaoDiaResponse other = (CotacaoDiaResponse) obj;
        return Objects.equals(value, other.value);
    }

    public Set<CotacaoResponse> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CotacaoDiaResponse [value=" + value + "]";
    }
}

