package prob03;

import java.util.Objects;

public class Money {
	private int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public Object add(Money money) {
		if(money instanceof Money) {
			return new Money(this.amount + money.amount);
		}
		
		return null;
	}

	public Object minus(Money money) {
		if(money instanceof Money) {
			return new Money(this.amount - money.amount);
		}
		return null;
	}

	public Object multiply(Money money) {
		if(money instanceof Money) {
			return new Money(this.amount * money.amount);
		}
		return null;
	}
	
	public Object divide(Money money) {
		if(money instanceof Money) {
			return new Money(this.amount / money.amount);
		}
		return null;
	}
	/* 코드 작성 */

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
}
