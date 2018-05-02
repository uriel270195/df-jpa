package com.axity.example.jpa.model;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * Entidad de la tabla C_PAIS
 * 
 * @author irvin uriel
 */
@Entity
@Table(name="C_PAIS")
public class CountryDO extends AbstractCatalogEntity<CountryDO> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8396170961936695640L;

	@Id
	@Column(name="ID_PAIS")
	private Integer idCountry;
	
	@OneToMany(mappedBy="country")
	private List<StationDO> stations;
	/**
	 * @return the idCountry
	 */
	public Integer getIdCountry() {
		return idCountry;
	}
	/**
	 * @param idCountry
	 *            the idCountry to set
	 */
	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}
	/**
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryDO other = (CountryDO) obj;
		if (idCountry == null) {
			if (other.idCountry != null)
				return false;
		} else if (!idCountry.equals(other.idCountry))
			return false;
		return true;
	}
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCountry == null) ? 0 : idCountry.hashCode());
		return result;
	}
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return new ToStringBuilder( this ).append( "idCountry", this.idCountry ).append( "stations", this.stations ).toString();
	}	

}
