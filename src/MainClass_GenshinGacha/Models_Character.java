package MainClass_GenshinGacha;

public class Models_Character {
	private String name;
	private String vision;
	private String Constelation;
	private String Description;
	private int value;
	private String imagec;
	
	public Models_Character(String name, String vision, String constelation, String description, int value, String imagec) {
		super();
		this.name = name;
		this.vision = vision;
		Constelation = constelation;
		Description = description;
		this.value = value;
		this.imagec = imagec;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVision() {
		return vision;
	}
	public void setVision(String vision) {
		this.vision = vision;
	}
	public String getConstelation() {
		return Constelation;
	}
	public void setConstelation(String constelation) {
		Constelation = constelation;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public String getImagec() {
		return imagec;
	}

	public void setImagec(String imagec) {
		this.imagec = imagec;
	}
}
