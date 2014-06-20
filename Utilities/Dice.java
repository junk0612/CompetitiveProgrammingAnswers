	class Dice {
		int top, front, right;

		Dice(int t, int f) {
			top = t;
			front = f;
			switch (t) {
			case 1:
				switch (f) {
				case 2:
					right = 3;
					break;
				case 3:
					right = 5;
					break;
				case 4:
					right = 2;
					break;
				case 5:
					right = 4;
					break;
				}
				break;
			case 2:
				switch (f) {
				case 1:
					right = 4;
					break;
				case 3:
					right = 1;
					break;
				case 4:
					right = 6;
					break;
				case 6:
					right = 3;
					break;
				}
				break;
			case 3:
				switch (f) {
				case 1:
					right = 2;
					break;
				case 2:
					right = 6;
					break;
				case 5:
					right = 1;
					break;
				case 6:
					right = 5;
					break;
				}
				break;
			case 4:
				switch (f) {
				case 1:
					right = 5;
					break;
				case 2:
					right = 1;
					break;
				case 5:
					right = 6;
					break;
				case 6:
					right = 2;
					break;
				}
				break;
			case 5:
				switch (f) {
				case 1:
					right = 3;
					break;
				case 3:
					right = 6;
					break;
				case 4:
					right = 1;
					break;
				case 6:
					right = 4;
					break;
				}
				break;
			case 6:
				switch (f) {
				case 2:
					right = 4;
					break;
				case 3:
					right = 2;
					break;
				case 4:
					right = 5;
					break;
				case 5:
					right = 3;
					break;
				}
				break;
			}
		}

		void rollR() {
			int t = 7 - right;
			right = top;
			top = t;
		}

		void rollL() {
			int t = 7 - top;
			top = right;
			right = t;
		}

		void rollF() {
			int t = 7 - front;
			front = top;
			top = t;
		}

		void rollB() {
			int t = 7 - top;
			top = front;
			front = t;
		}
	}
