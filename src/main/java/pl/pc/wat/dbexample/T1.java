package pl.pc.wat.dbexample;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "T1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "T1.findAll", query = "SELECT t FROM T1 t")
    , @NamedQuery(name = "T1.findByC1Strings", query = "SELECT t FROM T1 t WHERE t.c1Strings = :c1Strings")
    , @NamedQuery(name = "T1.findByC2Int", query = "SELECT t FROM T1 t WHERE t.c2Int = :c2Int")})
public class T1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "C1_STRINGS")
    private String c1Strings;
    @Column(name = "C2_INT")
    private Integer c2Int;

    public T1() {
    }

    public T1(String c1Strings) {
        this.c1Strings = c1Strings;
    }

    public String getC1Strings() {
        return c1Strings;
    }

    public void setC1Strings(String c1Strings) {
        this.c1Strings = c1Strings;
    }

    public Integer getC2Int() {
        return c2Int;
    }

    public void setC2Int(Integer c2Int) {
        this.c2Int = c2Int;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (c1Strings != null ? c1Strings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T1)) {
            return false;
        }
        T1 other = (T1) object;
        if ((this.c1Strings == null && other.c1Strings != null) || (this.c1Strings != null && !this.c1Strings.equals(other.c1Strings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pc.wat.dbexample.T1[ c1Strings=" + c1Strings + " ]";
    }
    
}
