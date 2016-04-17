package com.lki.excercise3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Manuel <191711>
 * @param <T>
 *            - type of powerSet
 * 
 */
public class PowerSet<T> {

	private static final int BEGINNING_VALUE = 1;
	private static final int ENDING_VALUE = 5;
	private static final String EMPTY_QUANTITY = "Ø";
	private Set<Set<T>> powerSet;

	public PowerSet(Set<Set<T>> powerSet) {
		this.powerSet = powerSet;
	}

	public static void main(String[] args) {
		Set<Integer> toTest = createTestData();
		System.out.println("Initial set: M=" + quantitySetAsString(toTest));
		PowerSet<Integer> powerSet = PowerSet.of(toTest);
		System.out.println("Result: P(M)=" + powerSet);
	}

	private static Set<Integer> createTestData() {
		Set<Integer> toTest = new HashSet<>();
		for (int i = BEGINNING_VALUE; i <= ENDING_VALUE; i++) {
			toTest.add(Integer.valueOf(i));
		}
		return toTest;
	}

	@Override
	public String toString() {
		return quantitySetAsString(powerSet);
	}

	public static String quantitySetAsString(Set<?> t) {
		String originalSetString = t.toString();
		String newString = originalSetString.replace('[', '{').replace(']', '}');
		newString = newString.replace("{}", EMPTY_QUANTITY);
		return newString;
	}

	public static <T> PowerSet<T> of(Collection<T> originalSet) {
		Set<Set<T>> powerSet = new HashSet<>();
		powerSet.add(new HashSet<T>());

		for (T item : originalSet) {
			Set<Set<T>> newPowerSet = new HashSet<>();

			for (Set<T> subset : powerSet) {
				// copy all of the current powerset's subsets
				newPowerSet.add(subset);

				// plus the subsets appended with the current item
				Set<T> newSubset = new HashSet<>(subset);
				newSubset.add(item);
				newPowerSet.add(newSubset);
			}

			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
			powerSet = newPowerSet;
		}
		return new PowerSet<T>(powerSet);
	}
}
