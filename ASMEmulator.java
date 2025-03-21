import java.util.Scanner;

public class ASMEmulator {
    private static int eax, ebx, ecx, edx;

    public static void mov(String reg1, int val) {
        setRegister(reg1, val);
    }
    public static void mov(String reg1, String reg2) {
        setRegister(reg1, getRegister(reg2));
    }
    public static void add(String reg1, int val) {
        eax = getRegister(reg1) + val;
    }
    public static void add(String reg1, String reg2) {
        eax = getRegister(reg1) + getRegister(reg2);
    }
    public static void imul(String reg1, int val) {
        eax = getRegister(reg1) * val;
    }
    public static void imul(String reg1, String reg2) {
        eax = getRegister(reg1) * getRegister(reg2);
    }
    public static void cmp(String reg1, int val) {
        eax = (getRegister(reg1) == val) ? 1 : 0;
    }
    public static void cmp(String reg1, String reg2) {
        eax = (getRegister(reg1) == getRegister(reg2)) ? 1 : 0;
    }
    public static void call(String proc, String reg1) {
        if (proc.equals("PRINT")) {
            System.out.println("[" + reg1 + "]: " + getRegister(reg1));
        }
    }
    public static int getRegister(String reg) {
        return switch (reg) {
            case "eax" -> eax;
            case "ebx" -> ebx;
            case "ecx" -> ecx;
            case "edx" -> edx;
            default -> throw new IllegalArgumentException("Invalid register: " + reg);
        };
    }
    public static void setRegister(String reg, int val) {
        switch (reg) {
            case "eax" -> eax = val;
            case "ebx" -> ebx = val;
            case "ecx" -> ecx = val;
            case "edx" -> edx = val;
            default -> throw new IllegalArgumentException("Invalid register: " + reg);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine() == true)
		{
			String line = input.nextLine();
			parseLine(line);
		}
        input.close();
	}
	public static void parseLine(String line)
	{
		Scanner parser = new Scanner(line);
		String instruction = parser.next();
		String reg1 = parser.next();
		if ( parser.hasNextInt() == true )
		{
			int value = parser.nextInt();
			executeMASM(instruction, reg1, value);
		}
		else
		{
			String reg2 = parser.next();
			executeMASM(instruction, reg1, reg2);
		}
        parser.close();
	}
	public static void executeMASM(String cmd, String reg1, String reg2)
	{
		switch(cmd)
		{
			case "MOV": mov(reg1, reg2); break;
			case "ADD": add(reg1, reg2); break;
			case "IMUL": imul(reg1, reg2); break;
			case "CMP": cmp(reg1, reg2); break;
			case "CALL": call(reg1, reg2); break;

		}
	}
	public static void executeMASM(String cmd, String reg1, int val1)
	{
		switch(cmd)
		{
			case "MOV": mov(reg1, val1); break;
			case "ADD": add(reg1, val1); break;
			case "IMUL": imul(reg1, val1); break;
			case "CMP": cmp(reg1, val1); break;
		}
    }
}