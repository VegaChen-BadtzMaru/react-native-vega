import vega from "../src/index";

describe("add function", () => {
	it("1 + 2 == 3", () => {
		expect(vega.add(1, 2)).toEqual(3);
	});
});
