package bitboolean;

/**
 *	<p>
 *	BitBoolean is a data type for representing booleans in byte format.
 *
 *	The boolean primitive type in Java uses one byte of memory, BitBoolean allows you to to use just one bit of memory for each boolean represented.
 *	
 *	However it only does this in multiples of eight. So if you wanted to represent just one boolean, it would still use one byte of memory. But if you wanted to represent four booleans, it would still just use one byte of memory. Eight booleans would take two bytes, and so on.
 *	</p>
 *
 *	@author Peter Tran
 */
public class BitBoolean
{
	private final byte[] bb;
	private final int number;
	private final int N;
	private final int leftover;

	/**
	 *	Creates a BitBoolean based on how many booleans you want to represent.
	 *
	 *	Initializes all the booleans to false.
	 */
	public BitBoolean(int bits)
	{
		// creates a arrays of bytes depending on how many booleans you want to represent
		// initialize all those bits to 0 (false)
		number = bits;
        N = (int) Math.floor(bits / 8.0);
        leftover = bits % 8;

        // create N + 1 arrays to account for spillage
        bb = new byte[N + 1];
        for (int i = 0; i <= N; i++)
        {
            bb[i] = (byte) 0b00000000;
        }
	}

	// returns a String representation of the byte
	private static String toString(byte b)
	{
		String s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
		return s;
	}

	/**
	 *	Flips the x'th bit in the BitBoolean.
	 */
	public void flip(int x)
	{
		if ((x <= number) && (x >= 0))
		{
			int array = (int) Math.floor(x / 8.0);
			int element = x % 8;

			String s = toString(this.bb[array]);

			byte flipper = (byte) (1 << element);

			this.bb[array] = (byte) (this.bb[array] ^ flipper);
		}
		else throw new RuntimeException("Index out of bounds!");
	}

	/**
	 *	Returns the boolean representation of the x'th bit in the BitBoolean.
	 *
	 *	@return the boolean representation of the x'th bit.
	 */
	public boolean check(int x)
	{
		if ((x <= number) && (x >= 0))
		{
			int array = (int) Math.floor(x / 8.0);
			int element = x % 8;
			element = 7 - element;

			String s = toString(this.bb[array]);
			if (s.charAt(element) == '1')
				return true;
			else
				return false;
		}
		else throw new RuntimeException("Index out of bounds!");
	}

	/**
	 *	Returns the size of the BitBoolean.
	 *
	 *	@return the size of the BitBoolean
	 */
	public int size()
	{
		return N * 8 + leftover;
	}

	/**
	 *	Returns a String representation of the BitBoolean.
	 *
	 *	@return a String representation of the BitBoolean.
	 */
	public String toString()
	{
		String s = "";
		for (int i = 0; i <= N; i++)
			s = s.concat(String.format("%8s", Integer.toBinaryString(bb[i] & 0xFF)).replace(' ', '0')) + "\n";

		return s;
	}
}
