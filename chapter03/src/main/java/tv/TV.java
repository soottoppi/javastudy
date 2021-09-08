package tv;

public class TV {
	private int channel;	// 1~255, 255에서 up -> 1, 1에서 down -> 255
	private int volume;		// 0~100, 0에서 
	private boolean power;
	
	public void status() {
		System.out.println(
				"TV [channel=" + channel +
				", volume=" + volume + 
				", power=" + power + "]"); 
	}

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		if(power) {
			if(channel >= 1 && channel <= 255) {
				this.channel = channel;	
			}
		}
	}
	
	public void channel( boolean up ) {
		if(up) {
			if(this.channel == 255) {
				channel(1);
			} else {
				channel(this.channel + 1);
			}
		} else {
			if(this.channel == 1) {
				channel(255);
			} else {
				channel(this.channel - 1);
			}
		}
	}
	
	public void volume( int volume ) {
		if(power) {
			if(volume >= 0 && volume <= 100) {
				this.volume = volume;
			}
			else {
				this.volume = 0;	// 잘못된 값 입력 시 0으로 초기화 
			}
		}
	}
	
	void volume( boolean up ) {
		if(up) {
			if(volume == 100) {
				volume(0);
			} else {
				volume(this.volume + 1);	
			}
			
		} else {
			if(volume == 0) {
				volume(100);
			} else {
				volume(this.volume - 1);	
			}
		}
	}
	
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	public boolean getPower() {
		return power;
	}
}
