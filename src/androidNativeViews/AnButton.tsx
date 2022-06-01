import * as React from "react";
import { FC } from "react";
import {
	ColorValue,
	HostComponent,
	Platform,
	requireNativeComponent,
	ViewProps,
} from "react-native";

interface OnClickEventI {
	timeStamp: number;
	nativeEvent: {
		message: string;
	};
}

export interface RNTAnButtonI extends ViewProps {
	text?: string;
	textSize?: number;
	backgroundColor?: ColorValue;
	onClick?: (event: OnClickEventI) => void;
}

const RNTAnButton: HostComponent<RNTAnButtonI> =
	requireNativeComponent("RNTAnButton");

export type AnButtonI = RNTAnButtonI;

const AnButton: FC<AnButtonI> = (props) => {
	const newProps: AnButtonI = {
		style: {
			height: 46,
		},
		textSize: 18,
		...props,
	};
	if (Platform.OS === "android") {
		return <RNTAnButton {...newProps} />;
	}
	return null;
};

export default AnButton;
