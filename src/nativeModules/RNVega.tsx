import { NativeModules, Platform } from "react-native";

interface DialogOptionsI {
	title?: string;
	message?: string;
	positive?: string;
	negative?: string;
}

export type RNVegaT = {
	sayHello: () => void;
	showDialog: (
		options: DialogOptionsI,
		positiveCB: () => void,
		negativeCB: () => void
	) => void;
};

const RNVegaModules = NativeModules.RNVega;

const RNVega: RNVegaT = {
	sayHello: () => {
		if (Platform.OS === "android") {
			RNVegaModules.sayHello();
		}
	},
	showDialog: (...params) => {
		if (Platform.OS === "android") {
			RNVegaModules.showDialog(...params);
		}
	},
};

export default RNVega;
