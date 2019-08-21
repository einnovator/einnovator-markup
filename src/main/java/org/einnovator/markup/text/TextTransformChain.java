/**
 * 
 */
package org.einnovator.markup.text;


/**
 * A TextTransformChain.
 *
 * @author  {@code support@einnovator.org}
 */
public class TextTransformChain implements TextTransform {

	protected TextTransform[] transforms;

	//
	// Constructors
	//
	
	/**
	 * Create instance of TextTransformChain.
	 *
	 */
	public TextTransformChain() {
	}
	
	/**
	 * Create instance of TextTransformChain.
	 *
	 * @param transforms variadic array of {@code TextTransform}
	 */
	public TextTransformChain(TextTransform... transforms) {
		this.transforms = transforms;
	}	

	//
	// Getters and setters
	//
	
	/**
	 * Get the value of transforms.
	 *
	 * @return the transforms
	 */
	public TextTransform[] getTransforms() {
		return transforms;
	}

	/**
	 * Set the value of transforms.
	 *
	 * @param transforms the transforms to set
	 */
	public void setTransforms(TextTransform[] transforms) {
		this.transforms = transforms;
	}

	//
	// TextTransform implementation
	//

	@Override
	public String transform(String text) {
		for (TextTransform transform: transforms) {
			text = transform.transform(text);
		}
		return text;
	}

}
