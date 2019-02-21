package br.com.itau.tudonovo.common;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

public abstract class QEntity {

	public static <T> Specification<T> equalsCaseIncensitive(String field, String value) {
		return (root, query, cb) -> {
			if (isEmpty(value))
				return null;

			return cb.equal(cb.lower(root.get(field)), value.toLowerCase());
		};
	}

	public static <T> Specification<T> equals(String field, Object value) {
		return (root, query, cb) -> {
			if (value == null)
				return null;

			return cb.equal(root.get(field), value);
		};
	}

	public static <T> Specification<T> likeAfterCaseIncensitive(String field, String value) {
		return (root, query, cb) -> {
			if (isEmpty(value))
				return null;

			return cb.like(cb.lower(root.get(field)), value.toLowerCase() + "%");
		};
	}

	public static <T> Specification<T> likeEverywereCaseIncensitive(String field, String value) {
		return (root, query, cb) -> {
			if (isEmpty(value))
				return null;

			return cb.like(cb.lower(root.get(field)), "%" + value.toLowerCase() + "%");
		};
	}

	public static <T, J> Specification<T> in(String field, List<J> values) {
		return (root, query, cb) -> {
			if (CollectionUtils.isEmpty(values)) {
				return null;
			}

			return root.get(field).in(values);
		};
	}
	
	public static <T, J> Specification<T> in(String field, J value) {
		return (root, query, cb) -> {
			if (value==null) {
				return null;
			}

			return root.get(field).in(value);
		};
	}

}
