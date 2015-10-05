package model;

public class Objet {
	
	private int id_objet;
	private String nom_objet;
	private float prix;
	
	public int getId_objet() {
		return id_objet;
	}
	public void setId_objet(int id_objet) {
		this.id_objet = id_objet;
	}
	public String getNom_objet() {
		return nom_objet;
	}
	public void setNom_objet(String nom_objet) {
		this.nom_objet = nom_objet;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objet other = (Objet) obj;
		if (id_objet != other.id_objet)
			return false;
		if (nom_objet == null) {
			if (other.nom_objet != null)
				return false;
		} else if (!nom_objet.equals(other.nom_objet))
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		return true;
	}
	
	

}
