import { NativeModules } from "react-native";

type RNVegaI = {
	sayHello: () => void;
};

const RNVega: RNVegaI = NativeModules.RNVega;

function add(a: number, b: number): number {
	return a + b;
}

function minus(a: number, b: number): number {
	return a - b;
}

const vega = { add, minus, RNVega };

export default vega;
