package model;

public class Categorie {
	
	private int id_cat;
	private String nom_cat;
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getNom_cat() {
		return nom_cat;
	}
	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		if (id_cat != other.id_cat)
			return false;
		if (nom_cat == null) {
			if (other.nom_cat != null)
				return false;
		} else if (!nom_cat.equals(other.nom_cat))
			return false;
		return true;
	}
	
	

}
