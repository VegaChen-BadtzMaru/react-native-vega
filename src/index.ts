import { NativeModules } from "react-native";

type RNVegaT = {
	sayHello: () => void;
};

const RNVega: RNVegaT = NativeModules.RNVega;

function add(a: number, b: number): number {
	return a + b;
}

function minus(a: number, b: number): number {
	return a - b;
}

const vega = { add, minus, RNVega };

export default vega;
