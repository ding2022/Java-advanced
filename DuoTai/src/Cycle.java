class Cycle {
	public void play() {
		System.out.println("a");
	}
}

class Uncycle extends Cycle {
	public void play() {
		System.out.println("un");
	}
}

class Bicycle extends Cycle {
	public void play() {
		System.out.println("by");
	}
}
class Tricycle extends Cycle {
	public void play() {
		System.out.println("tr");
	}

}