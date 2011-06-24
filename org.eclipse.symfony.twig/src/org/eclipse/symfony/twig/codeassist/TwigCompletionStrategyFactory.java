package org.eclipse.symfony.twig.codeassist;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.symfony.twig.codeassist.context.TemplateVariableCompletionContext;
import org.eclipse.symfony.twig.codeassist.context.TemplateVariableFieldCompletionContext;
import org.eclipse.symfony.twig.codeassist.strategies.TemplateVariableCompletionStrategy;
import org.eclipse.symfony.twig.codeassist.strategies.TemplateVariableFieldCompletionStrategy;
import org.eclipse.twig.core.codeassist.ITwigCompletionStrategyFactory;
import org.eclipse.twig.core.codeassist.strategies.AbstractTwigCompletionStrategy;

/**
 * 
 * {@link TwigCompletionStrategyFactory} provides Symfony2 completion
 * strategies for the Twig plugin.
 *  
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigCompletionStrategyFactory implements
		ITwigCompletionStrategyFactory {

	public TwigCompletionStrategyFactory() {

	}


	@Override
	public AbstractTwigCompletionStrategy[] create(ICompletionContext[] contexts) {


		List<AbstractTwigCompletionStrategy> result = new LinkedList<AbstractTwigCompletionStrategy>();
		
		for (ICompletionContext context : contexts) {
			if (context.getClass() == TemplateVariableCompletionContext.class) {
				result.add(new TemplateVariableCompletionStrategy(context));
			} else if (context.getClass() == TemplateVariableFieldCompletionContext.class) {				
				result.add(new TemplateVariableFieldCompletionStrategy(context));
			}
		}
		
		return (AbstractTwigCompletionStrategy[]) result
		        .toArray(new AbstractTwigCompletionStrategy[result.size()]);
				
	}
}
