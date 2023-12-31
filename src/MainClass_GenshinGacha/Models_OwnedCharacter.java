package MainClass_GenshinGacha;

public class Models_OwnedCharacter {
	private String name;
	private String vision;
	private int value;
	
	public Models_OwnedCharacter(String name, String vision, int value) {
		super();
		this.name = name;
		this.vision = vision;
		this.value = value;
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
	
	
