// These are the three different possible results of a guess. I thought Strings are too messy for this purpose and that
// booleans are limited to only two states. ints are difficult to decipher and therefore error-prone. Therefore an
// enumeration is the best option here
public enum GuessResult {
	LOW, CORRECT, HIGH
}
