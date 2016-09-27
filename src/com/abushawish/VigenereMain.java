package com.abushawish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//Mohammed Abushawish
//100857775

public class VigenereMain {

	public static void main(String[] args) {

		String cipherText = "jauew evpe mddbcwyy fhvf ycyw af kap cezqr rgtalde oe mss"
				+ " qsdm thfzo yqt wnchswd tyty hsw xekmpf ltodvyr o tl iaj twgz xauew "
				+ "evll fhv leiaapei tywxsxs jnnv lk fhv lssph teel lbo vgcbl hscw gnruws "
				+ "eg xerky hsw eemxy qzeyaewxsyle bp apocl mfkxc afut tyhfusl enfpmowd "
				+ "petelfpv fhrm evp kqvvg ncxemnufpbek ooleo wy wrfvve pp jqdlvpr eg m "
				+ "szgrzp emxzf yoxwxy whff wwss xhzr eoa lvzd plv fhzl ss dsud thyhlazeu mss "
				+ "pkeeemtow sncuxqu ajuntbazp gr aebxowaem nazsgwd hrw evzjauxawm rjmsgxo we "
				+ "oaucw ms dsre wkza smyae bytwmqntxd hsw niiwd oe xurjm zpuwotvw dwyuq ik lpsxwp "
				+ "tf mssx ltak mssj sxsf alr eoa lvzd pfl enfpmowd brfopr eg fhvf evll fhzl hod "
				+ "fat jh l ptjp s nbyu ngyrrwpg sw eazw tg lf arxty cq hdognwgtgz aew yce gr "
				+ "mrgtdfdmtzhy we sncuxqu dzaucw evpjqffkp pp jqgrkoso se a cxr hsw pijmtbrmusybyu "
				+ "xsdk fy xoy ae tyx soyv fhv bygejgmvge ktlt wybnv sw povl lzw zus dbdqsaqf kap "
				+ "ptjps ubo bzl gnuxcgeszd runrpxs sehhpldx s chyu hgddj ufh ezqy rvnsalqd ybd "
				+ "sihxaetewzf mnu twz ezq hlfmzpj mnzflzd kqt kh hccc fo cxlfy lte exh alpum sr "
				+ "ssljf ffnc zpye gfho hhg xexl moo oms zgdqcaneu hy hsw qnu plzw gr tyx mocf mbfop "
				+ "hsw eemxy qzeyaewxsyle aew tb masgvk wselqrj pssy ltep alr zfoe xhe we tk hvtch "
				+ "ltodvyr hsw ehvxa rpnqlfipr l yderm wwvazg whc hsae mrqta lfp owmpb lk fhvr woj az "
				+ "tyx qwpdp tyxj kzmxd rew gesdt sepoeazg whff wwss xhzr eoa lvzd plv rolk wsrk "
				+ "sofw ekz dqgj ulr lfp kvxa we mb ffk scfje oe xyr ywhei zcchazg kbcso gr ik "
				+ "gldzdqoe mzcv fa iempfpkf ie lychtmlc l ncxeutkxpg sw eazw evll fhv xoinsfifg zt "
				+ "ezq yfnyu hse mfkp wxharktyh ezmn rgjhsazg kalh ngglu up rzfq ffk evzkq wyh hscw"
				+ " mlixlrj ydong fd tl tagipbpv fhrm usdkue rgo pwmqbvew vlv noka hvpdbeu lzcy srtvk "
				+ "evp zmy ytcjpkf gzotbr turka mseoqee mssx la nzgp gemddp ifdaaqs rl dczf ms kapm hwde "
				+ "nxlbpv zaghwszf fofd evpe mwrr qfze fhvbc azlteil dojazg kalh sw ioleo alcq hzfdswx "
				+ "dejizbdanlv yzf ezqii xoinsfifg ss egak kapa fh unkh l zzxf wybnv ngglu hyzj tq "
				+ "rvtnvpv ny r elrowd fihx hsw taigpgd jaod tyr ezqrv dpde lted by gfut svvwidaan "
				+ "kalh ezq rvle cq lte wtca dgan whcuzl fhvbc siaetvgns ezq mplescq af napfp lte dbwy "
				+ "hwzt kh hod kaoe vwsljqd li th hse mzqpr pnqrp wlm tffo kap dtye mrls hsw qaiej "
				+ "oahxej ppfp faw ibasyazg rgo hsw srrld cq lte fknvljp wrl wwelqrvw hwez iiewqowde "
				+ "tyx lbtemlj alr lkeudxo od s yakmpf zx oolkds ezmt kapgp oaucw ms dzmrvw zie wcurewm "
				+ "zfq drr schwhei mss zjpei ppbe xarka evll mlc mss hazdwtwzd oqrv mz pp ualcxnhpv mnu "
				+ "uccfytt kh evp zmrexdg cgam whc hsw";
		int maxPossibleKeyLength = 30;

		String cipherTextEdited = cipherText.replaceAll("\\s", "").toUpperCase();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Max length of the key (Indexs of Coincidences): " + maxPossibleKeyLength + "\n");

		// Create sequences of cipher
		createSequences(cipherTextEdited, maxPossibleKeyLength);

		int keyLength;
		while (true) {
			System.out.print("\nEnter assumed key length using the above IoC (generally largest IoC): \n");
			try {
				keyLength = Integer.parseInt(reader.readLine());
				if (keyLength > 0 && keyLength <= maxPossibleKeyLength) {
					break;
				} else {
					System.out.println(
							"Key length must be an integer greater than 0 and less than " + maxPossibleKeyLength + 1);
				}
			} catch (NumberFormatException e) {
				System.out.println("Entered value must be an integer. Try again.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String guessedKey = guessKeyWithLength(cipherTextEdited, keyLength);
		String typedKey;

		while (true) {
			System.out.println("\nThe guessed key is: " + guessedKey
					+ ". Make sure that it makes sense (may need to make logical changes using above Chi values) type it to continue: ");
			try {
				typedKey = reader.readLine();
				if (typedKey.toString().length() == guessedKey.length()) {
					break;
				} else {
					System.out.println("Entered key length must be " + guessedKey.length());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String decrypted = decryptUsingKey(cipherTextEdited, typedKey);
		decrypted = placeSpaces(cipherText, decrypted); // Add spaces

		System.out.println("\nThe cipherText says: \n" + decrypted);
	}

	// Creates sequences for given cipherText up to max keylength
	public static void createSequences(String cipherText, int maxLength) {

		// The IOC for every key length
		ArrayList<Double> iocForKeyLengths = new ArrayList<Double>();
		// The various sequences
		ArrayList<String> sequences = new ArrayList<String>();

		// Start from the first letter and loop to each next letter according to
		// possible key lengths adding each once to a sequence which is then
		// added to a list
		int startAt = 0;
		for (int possKeyLength = 1; possKeyLength <= maxLength; possKeyLength++) {
			String newSequence = "";
			while (startAt < possKeyLength) {
				for (int i = startAt; i < cipherText.length(); i += possKeyLength) {
					newSequence += cipherText.charAt(i);

				}
				sequences.add(newSequence);
				newSequence = "";
				startAt++;
			}
			System.out.println(possKeyLength + "    " + calculateIoC(sequences));
			iocForKeyLengths.add(calculateIoC(sequences));
			sequences.clear();
			startAt = 0;
		}
	}

	// Index of Coincidence for a set of sequences/strings
	public static double calculateIoC(ArrayList<String> sequences) {

		ArrayList<Double> averages = new ArrayList<Double>();
		for (int avgSeq = 0; avgSeq < sequences.size(); avgSeq++) {
			int num = 0;
			double sum = 0.0;
			int[] values = new int[26];
			for (int i = 0; i < 26; i++) {
				values[i] = 0;
			}

			// Frequency of each letter in the sequence
			int character;
			for (int i = 0; i < sequences.get(avgSeq).length(); i++) {
				character = sequences.get(avgSeq).charAt(i) - 65;
				if (character >= 0 && character < 26) {
					values[character]++;
					num++;
				}
			}

			for (int i = 0; i < 26; i++) {
				character = values[i];
				sum = sum + (character * (character - 1));
			}

			averages.add(sum / (num * (num - 1)));
		}

		// Calculate the average IoC for all sequences
		double sum = 0;
		for (Double avg : averages) {
			sum += avg;
		}

		return sum / averages.size();
	}

	// Guess the key when given the max length of the key
	public static String guessKeyWithLength(String cipherText, int maxLength) {

		ArrayList<String> sequences = new ArrayList<String>();
		String newSequence = "";
		int startAt = 0;
		while (startAt < maxLength) {
			for (int i = startAt; i < cipherText.length(); i += maxLength) {
				newSequence += cipherText.charAt(i);

			}
			sequences.add(newSequence);
			newSequence = "";
			startAt++;
		}

		String guessedKey = "";

		for (int i = 0; i < maxLength; i++) {
			System.out.println("\nPosition " + i + " of key: ");
			System.out.println("Shift  |    Sequence            |            Chi Sum");
			System.out.println("______________________________________________________________");

			// The probable letters for each position
			guessedKey += probLetterForIndex(maxLength, sequences.get(i).length(), sequences.get(i));
		}

		return guessedKey;
	}

	// Calculates the most probable letter for the each letter in key
	private static char probLetterForIndex(int keyLength, int cipherLength, String substring) {

		// The frequencies of the alphabet in the English language A to Z
		double[] englishFreq = { 0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015, 0.06094, 0.06966,
				0.00153, 0.00772, 0.04025, 0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987, 0.06327, 0.09056,
				0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074 };
		ArrayList<Double> chiSums = new ArrayList<Double>();

		// Essentially a caesar cipher on steroids, shift each letter starting
		// from 0 all the way to 26, and calculate the chi sum
		for (int shift = 0; shift < 26; shift++) {
			double chiSum = 0;
			int ASCIILetterA = 65;
			int countLetterOcc = 0;
			String shiftedMessage = "";

			for (int i = 0; i < substring.length(); i++) {
				int c = substring.charAt(i) - (shift % 26);
				if (c < 'A') {
					c = c + 26;
				}
				shiftedMessage = shiftedMessage + (char) c;
			}

			// Calculate the chi value for each letter of the alphabet
			for (int i = 0; i < 26; i++) {

				// How many times this letter occurs in the String
				countLetterOcc = shiftedMessage.length()
						- shiftedMessage.replace(String.valueOf(Character.toChars(ASCIILetterA + i)), "").length();

				double x = countLetterOcc - ((cipherLength) * englishFreq[i]);

				double numirator = Math.pow(x, 2);

				chiSum += numirator / (cipherLength * englishFreq[i]); // Chill
																		// value
			}
			chiSums.add(chiSum);

			System.out.println(shift + "        " + shiftedMessage + "         " + chiSum);

		}

		// Find the smallest chi value indicating most probable letter
		int minLetterIndex = chiSums.indexOf(Collections.min(chiSums));
		char minLetter = (char) ((minLetterIndex % 26) + 'A');

		System.out.println("Prob letter: " + minLetter + " due to the chi value.");
		System.out.println("_____________________________________________________________");

		return minLetter;
	}

	// Decrypt the cipher using the known/guessed key
	public static String decryptUsingKey(String cipherText, String key) {

		String decrypted = "";
		for (int i = 0, j = 0; i < cipherText.length(); i++) {
			char c = cipherText.charAt(i);
			if (c < 'A' || c > 'Z')
				continue;
			decrypted += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
			j = ++j % key.length();
		}
		return decrypted;
	}

	// Adds spaces to decrypted message because they were stripped from the
	// cipherText
	private static String placeSpaces(String cipherText, String decrypted) {

		// FiFo for whitespaces
		Queue<Integer> locationOfSpace = new LinkedList<Integer>();
		for (int i = 0; i < cipherText.length(); i++) {
			if (cipherText.charAt(i) == ' ') {
				locationOfSpace.add(i);
			}
		}
		
		System.out.println("num of spaces is " + locationOfSpace.size());

		StringBuilder str = new StringBuilder(decrypted);

		int numOfSpaces = locationOfSpace.size();
		for (int i = 0; i < numOfSpaces; i++) {
			int loc = locationOfSpace.remove();
			str.insert(loc, " ");
			System.out.println(i);
		}
		return str.toString();
	}
}
