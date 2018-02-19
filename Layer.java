abstract class Layer
{
	protected Vec activation;
	protected Vec blame;
	protected int inputs, outputs;

	Layer(int inputs, int outputs)
	{
		activation = new Vec(outputs);
		blame = new Vec(outputs);
		this.inputs = inputs;
		this.outputs = outputs;
	}

	Vec getActivation() { return activation; }
	Vec getBlame() { return blame; }

	// Deep copy
	void setBlame(Vec blame) {
		this.blame = new Vec(blame);
	}

	abstract void activate(Vec weights, Vec x);

	abstract void backProp(Vec weights, Vec prevBlame);

	abstract void updateGradient(Vec x, Vec gradient);

	abstract int getNumberWeights();
}
