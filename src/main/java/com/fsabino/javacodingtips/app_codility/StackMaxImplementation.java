package com.fsabino.javacodingtips.app_codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class StackMaxImplementation {

	private static final int MAX = 3;

	private final Integer[] repository;
	private int index;

	public StackMaxImplementation() {
		repository = new Integer[MAX];
		index = 0;
	}

	private void push(int number) {
		if (isMax()) {
			throw new RuntimeException("Full Capacity");
		}
		repository[index] = number;
		index++;
	}

	private int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Repository is empty");
		}
		index--;
		int value = repository[index];
		repository[index] = null;
		return value;
	}

	private int top() {
		if (isEmpty()) {
			throw new RuntimeException("Repository is empty");
		}
		return repository[index - 1];
	}

	private boolean isEmpty() {
		return index == 0;
	}

	private boolean isMax() {
		return index == MAX;
	}

	@Test
	public void given_IhaveAnHuman_when_executeTheStack_then_TheResultsShouldBeCorrect() {
		// given
		StackMaxImplementation stack = new StackMaxImplementation();

		// when & then
		assertThat(stack.isEmpty()).isTrue();
		assertThatThrownBy(() -> stack.pop()).isInstanceOf(RuntimeException.class).hasMessage("Repository is empty");
		assertThatThrownBy(() -> stack.top()).isInstanceOf(RuntimeException.class).hasMessage("Repository is empty");
		stack.push(20);
		assertThat(stack.top()).isEqualTo(20);
		stack.push(30);
		assertThat(stack.top()).isEqualTo(30);
		stack.push(40);
		assertThat(stack.top()).isEqualTo(40);
		assertThatThrownBy(() -> stack.push(50)).isInstanceOf(RuntimeException.class).hasMessage("Full Capacity");
		assertThat(stack.pop()).isEqualTo(40);
		assertThat(stack.top()).isEqualTo(30);
		assertThat(stack.pop()).isEqualTo(30);
		assertThat(stack.top()).isEqualTo(20);
		assertThat(stack.isEmpty()).isFalse();
		assertThat(stack.pop()).isEqualTo(20);
		assertThat(stack.isEmpty()).isTrue();
	}
}
