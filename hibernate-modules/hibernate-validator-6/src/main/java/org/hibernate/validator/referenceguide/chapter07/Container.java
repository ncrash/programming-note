package org.hibernate.validator.referenceguide.chapter07;

import java.util.OptionalInt;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.valueextraction.Unwrapping;

import com.google.common.collect.Multimap;

@SuppressWarnings({ "restriction", "unused" })
public class Container {

	//tag::multimapValues[]
	private Multimap<String, @NotBlank String> map1;
	//end::multimapValues[]

	//tag::multimapKeysAndValues[]
	private Multimap<@NotBlank String, @NotBlank String> map2;
	//end::multimapKeysAndValues[]

	//tag::optionalIntUnwrap[]
	@Min(value = 5, payload = Unwrapping.Unwrap.class)
	private OptionalInt optionalInt1;
	//end::optionalIntUnwrap[]

	//tag::optionalInt[]
	@Min(5)
	private OptionalInt optionalInt2;
	//end::optionalInt[]

	//tag::optionalIntSkip[]
	@NotNull(payload = Unwrapping.Skip.class)
	@Min(5)
	private OptionalInt optionalInt3;
	//end::optionalIntSkip[]

	//tag::stringProperty[]
	@NotBlank
	private String stringProperty;
	//end::stringProperty[]

	//tag::longProperty[]
	@Min(5)
	private Long longProperty;
	//end::longProperty[]

	//tag::listProperty[]
	@Size(min = 1)
	private List<@NotBlank String> listProperty;
	//end::listProperty[]
}
