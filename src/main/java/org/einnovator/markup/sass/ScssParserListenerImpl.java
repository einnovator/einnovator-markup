/**
 * 
 */
package org.einnovator.markup.sass;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.markup.sass.antlr.ScssParser.AttribContext;
import org.einnovator.markup.sass.antlr.ScssParser.AttribRelateContext;
import org.einnovator.markup.sass.antlr.ScssParser.BlockContext;
import org.einnovator.markup.sass.antlr.ScssParser.CommandStatementContext;
import org.einnovator.markup.sass.antlr.ScssParser.ConditionContext;
import org.einnovator.markup.sass.antlr.ScssParser.ConditionsContext;
import org.einnovator.markup.sass.antlr.ScssParser.EachDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.EachValueListContext;
import org.einnovator.markup.sass.antlr.ScssParser.ElementContext;
import org.einnovator.markup.sass.antlr.ScssParser.ElseIfStatementContext;
import org.einnovator.markup.sass.antlr.ScssParser.ElseStatementContext;
import org.einnovator.markup.sass.antlr.ScssParser.ExpressionContext;
import org.einnovator.markup.sass.antlr.ScssParser.ForDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.FromNumberContext;
import org.einnovator.markup.sass.antlr.ScssParser.FunctionBodyContext;
import org.einnovator.markup.sass.antlr.ScssParser.FunctionCallContext;
import org.einnovator.markup.sass.antlr.ScssParser.FunctionDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.FunctionReturnContext;
import org.einnovator.markup.sass.antlr.ScssParser.FunctionStatementContext;
import org.einnovator.markup.sass.antlr.ScssParser.IdentifierContext;
import org.einnovator.markup.sass.antlr.ScssParser.IdentifierListOrMapContext;
import org.einnovator.markup.sass.antlr.ScssParser.IdentifierPartContext;
import org.einnovator.markup.sass.antlr.ScssParser.IdentifierValueContext;
import org.einnovator.markup.sass.antlr.ScssParser.IdentifierVariableNameContext;
import org.einnovator.markup.sass.antlr.ScssParser.IfDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.ImportDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.IncludeDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.MathCharacterContext;
import org.einnovator.markup.sass.antlr.ScssParser.MathStatementContext;
import org.einnovator.markup.sass.antlr.ScssParser.MeasurementContext;
import org.einnovator.markup.sass.antlr.ScssParser.MediaTypesContext;
import org.einnovator.markup.sass.antlr.ScssParser.MixinDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.NestContext;
import org.einnovator.markup.sass.antlr.ScssParser.NestedContext;
import org.einnovator.markup.sass.antlr.ScssParser.ParamContext;
import org.einnovator.markup.sass.antlr.ScssParser.ParamOptionalValueContext;
import org.einnovator.markup.sass.antlr.ScssParser.ParamsContext;
import org.einnovator.markup.sass.antlr.ScssParser.PropertyContext;
import org.einnovator.markup.sass.antlr.ScssParser.PseudoContext;
import org.einnovator.markup.sass.antlr.ScssParser.ReferenceUrlContext;
import org.einnovator.markup.sass.antlr.ScssParser.RulesetContext;
import org.einnovator.markup.sass.antlr.ScssParser.SelectorContext;
import org.einnovator.markup.sass.antlr.ScssParser.SelectorPrefixContext;
import org.einnovator.markup.sass.antlr.ScssParser.SelectorsContext;
import org.einnovator.markup.sass.antlr.ScssParser.StatementContext;
import org.einnovator.markup.sass.antlr.ScssParser.StylesheetContext;
import org.einnovator.markup.sass.antlr.ScssParser.ThroughNumberContext;
import org.einnovator.markup.sass.antlr.ScssParser.UrlContext;
import org.einnovator.markup.sass.antlr.ScssParser.ValuesContext;
import org.einnovator.markup.sass.antlr.ScssParser.VariableDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParser.VariableNameContext;
import org.einnovator.markup.sass.antlr.ScssParser.WhileDeclarationContext;
import org.einnovator.markup.sass.antlr.ScssParserListener;
import org.einnovator.script.model.JExpr;
import org.einnovator.script.model.JLiteral;
import org.einnovator.script.model.JOperationX;
import org.einnovator.script.model.JOperationXY;
import org.einnovator.script.model.JVarRef;

/**
 * @author support@einnovator.org
 *
 */
public class ScssParserListenerImpl implements ScssParserListener {

	private final Log logger = LogFactory.getLog(getClass()); 

	Stylesheet stylesheet;
	
	Stack<StyleRule> rules = new Stack<>();
	
	StyleProperty property;
	
	StyleVariable var;
	
	JExpr expr;
	
	boolean bexpr;
	
	/**
	 * Create instance of {@code ScssParserListenerImpl}.
	 *
	 */
	public ScssParserListenerImpl() {
	}
	
	/**
	 * Get the value of property {@code stylesheet}.
	 *
	 * @return the stylesheet
	 */
	public Stylesheet getStylesheet() {
		return stylesheet;
	}

	/**
	 * Set the value of property {@code stylesheet}.
	 *
	 * @param stylesheet the stylesheet to set
	 */
	public void setStylesheet(Stylesheet stylesheet) {
		this.stylesheet = stylesheet;
	}
	
	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterStylesheet(org.einnovator.markup.sass.antlr.ScssParser.StylesheetContext)
	 */
	@Override
	public void enterStylesheet(StylesheetContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterStylesheet:" + ctx.getText());			
		}
		stylesheet = new Stylesheet();
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitStylesheet(org.einnovator.markup.sass.antlr.ScssParser.StylesheetContext)
	 */
	@Override
	public void exitStylesheet(StylesheetContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitStylesheet:" + ctx.getText());			
		}
	}


	/* 
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#visitTerminal(org.antlr.v4.runtime.tree.TerminalNode)
	 */
	@Override
	public void visitTerminal(TerminalNode node) {
		if (logger.isDebugEnabled()) {
			logger.debug("visitTerminal:" + node);			
		}
		if (bexpr || expr!=null) {
			JLiteral literal = new JLiteral(node.getText());
			addExpr(literal);
		}
	}

	private void addExpr(JExpr expr2) {
		if (expr!=null) {
			if (expr instanceof JOperationX) {
				((JOperationX)expr).setValue(expr2);
			} else if (expr instanceof JOperationXY) {
				if (((JOperationXY)expr).getLeft()==null) {
					((JOperationXY)expr).setLeft(expr2);						
				} else {
					((JOperationXY)expr).setRight(expr2);												
				}
			} 
		} else {
			expr = expr2;
		}
	}
	/* 
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#visitErrorNode(org.antlr.v4.runtime.tree.ErrorNode)
	 */
	@Override
	public void visitErrorNode(ErrorNode node) {
		if (logger.isDebugEnabled()) {
			logger.debug("visitErrorNode:" + node);			
		}

		
	}

	/* 
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#enterEveryRule(org.antlr.v4.runtime.ParserRuleContext)
	 */
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if (logger.isTraceEnabled()) {
			logger.trace("enterEveryRule:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.antlr.v4.runtime.tree.ParseTreeListener#exitEveryRule(org.antlr.v4.runtime.ParserRuleContext)
	 */
	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		if (logger.isTraceEnabled()) {
			logger.trace("exitEveryRule:" + ctx.getText());			
		}

	}


	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterStatement(org.einnovator.markup.sass.antlr.ScssParser.StatementContext)
	 */
	@Override
	public void enterStatement(StatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterStatement:" + ctx.getText());			
		}
		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitStatement(org.einnovator.markup.sass.antlr.ScssParser.StatementContext)
	 */
	@Override
	public void exitStatement(StatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitStatement:" + ctx.getText());			
		}
		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterParams(org.einnovator.markup.sass.antlr.ScssParser.ParamsContext)
	 */
	@Override
	public void enterParams(ParamsContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterParams:" + ctx.getText());			
		}
		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitParams(org.einnovator.markup.sass.antlr.ScssParser.ParamsContext)
	 */
	@Override
	public void exitParams(ParamsContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitParams:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterParam(org.einnovator.markup.sass.antlr.ScssParser.ParamContext)
	 */
	@Override
	public void enterParam(ParamContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterParam:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitParam(org.einnovator.markup.sass.antlr.ScssParser.ParamContext)
	 */
	@Override
	public void exitParam(ParamContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitParam:" + ctx.getText());			
		}		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterVariableName(org.einnovator.markup.sass.antlr.ScssParser.VariableNameContext)
	 */
	@Override
	public void enterVariableName(VariableNameContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterVariableName:" + ctx.getText());			
		}
		String name = ctx.getText().substring(1);
		if (var!=null && var.getName()==null) {
			var.setName(name);
		} else {
			JExpr expr = new JVarRef(name);
			addExpr(expr);
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitVariableName(org.einnovator.markup.sass.antlr.ScssParser.VariableNameContext)
	 */
	@Override
	public void exitVariableName(VariableNameContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitVariableName:" + ctx.getText());			
		}		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterParamOptionalValue(org.einnovator.markup.sass.antlr.ScssParser.ParamOptionalValueContext)
	 */
	@Override
	public void enterParamOptionalValue(ParamOptionalValueContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterParamOptionalValue:" + ctx.getText());			
		}		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitParamOptionalValue(org.einnovator.markup.sass.antlr.ScssParser.ParamOptionalValueContext)
	 */
	@Override
	public void exitParamOptionalValue(ParamOptionalValueContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitParamOptionalValue:" + ctx.getText());			
		}		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterMixinDeclaration(org.einnovator.markup.sass.antlr.ScssParser.MixinDeclarationContext)
	 */
	@Override
	public void enterMixinDeclaration(MixinDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterMixinDeclaration:" + ctx.getText());			
		}		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitMixinDeclaration(org.einnovator.markup.sass.antlr.ScssParser.MixinDeclarationContext)
	 */
	@Override
	public void exitMixinDeclaration(MixinDeclarationContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitMixinDeclaration:" + ctx.getText());			
		}		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterIncludeDeclaration(org.einnovator.markup.sass.antlr.ScssParser.IncludeDeclarationContext)
	 */
	@Override
	public void enterIncludeDeclaration(IncludeDeclarationContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterIncludeDeclaration:" + ctx.getText());			
		}	
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitIncludeDeclaration(org.einnovator.markup.sass.antlr.ScssParser.IncludeDeclarationContext)
	 */
	@Override
	public void exitIncludeDeclaration(IncludeDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitIncludeDeclaration:" + ctx.getText());			
		}	
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterFunctionDeclaration(org.einnovator.markup.sass.antlr.ScssParser.FunctionDeclarationContext)
	 */
	@Override
	public void enterFunctionDeclaration(FunctionDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterFunctionDeclaration:" + ctx.getText());			
		}	
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitFunctionDeclaration(org.einnovator.markup.sass.antlr.ScssParser.FunctionDeclarationContext)
	 */
	@Override
	public void exitFunctionDeclaration(FunctionDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitFunctionDeclaration:" + ctx.getText());			
		}	
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterFunctionBody(org.einnovator.markup.sass.antlr.ScssParser.FunctionBodyContext)
	 */
	@Override
	public void enterFunctionBody(FunctionBodyContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterFunctionBody:" + ctx.getText());			
		}	
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitFunctionBody(org.einnovator.markup.sass.antlr.ScssParser.FunctionBodyContext)
	 */
	@Override
	public void exitFunctionBody(FunctionBodyContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitFunctionBody:" + ctx.getText());			
		}	
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterFunctionReturn(org.einnovator.markup.sass.antlr.ScssParser.FunctionReturnContext)
	 */
	@Override
	public void enterFunctionReturn(FunctionReturnContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterFunctionReturn:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitFunctionReturn(org.einnovator.markup.sass.antlr.ScssParser.FunctionReturnContext)
	 */
	@Override
	public void exitFunctionReturn(FunctionReturnContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitFunctionReturn:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterFunctionStatement(org.einnovator.markup.sass.antlr.ScssParser.FunctionStatementContext)
	 */
	@Override
	public void enterFunctionStatement(FunctionStatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterFunctionStatement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitFunctionStatement(org.einnovator.markup.sass.antlr.ScssParser.FunctionStatementContext)
	 */
	@Override
	public void exitFunctionStatement(FunctionStatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitFunctionStatement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterCommandStatement(org.einnovator.markup.sass.antlr.ScssParser.CommandStatementContext)
	 */
	@Override
	public void enterCommandStatement(CommandStatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterCommandStatement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitCommandStatement(org.einnovator.markup.sass.antlr.ScssParser.CommandStatementContext)
	 */
	@Override
	public void exitCommandStatement(CommandStatementContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitCommandStatement:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterMathCharacter(org.einnovator.markup.sass.antlr.ScssParser.MathCharacterContext)
	 */
	@Override
	public void enterMathCharacter(MathCharacterContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterMathCharacter:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitMathCharacter(org.einnovator.markup.sass.antlr.ScssParser.MathCharacterContext)
	 */
	@Override
	public void exitMathCharacter(MathCharacterContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitMathCharacter:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterMathStatement(org.einnovator.markup.sass.antlr.ScssParser.MathStatementContext)
	 */
	@Override
	public void enterMathStatement(MathStatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterMathStatement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitMathStatement(org.einnovator.markup.sass.antlr.ScssParser.MathStatementContext)
	 */
	@Override
	public void exitMathStatement(MathStatementContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitMathStatement:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterExpression(org.einnovator.markup.sass.antlr.ScssParser.ExpressionContext)
	 */
	@Override
	public void enterExpression(ExpressionContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterExpression:" + ctx.getText());			
		}
		bexpr = true;
		expr = null;
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitExpression(org.einnovator.markup.sass.antlr.ScssParser.ExpressionContext)
	 */
	@Override
	public void exitExpression(ExpressionContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitExpression:" + ctx.getText());			
		}
		bexpr = false;
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterIfDeclaration(org.einnovator.markup.sass.antlr.ScssParser.IfDeclarationContext)
	 */
	@Override
	public void enterIfDeclaration(IfDeclarationContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterIfDeclaration:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitIfDeclaration(org.einnovator.markup.sass.antlr.ScssParser.IfDeclarationContext)
	 */
	@Override
	public void exitIfDeclaration(IfDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitIfDeclaration:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterElseIfStatement(org.einnovator.markup.sass.antlr.ScssParser.ElseIfStatementContext)
	 */
	@Override
	public void enterElseIfStatement(ElseIfStatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterElseIfStatement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitElseIfStatement(org.einnovator.markup.sass.antlr.ScssParser.ElseIfStatementContext)
	 */
	@Override
	public void exitElseIfStatement(ElseIfStatementContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitElseIfStatement:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterElseStatement(org.einnovator.markup.sass.antlr.ScssParser.ElseStatementContext)
	 */
	@Override
	public void enterElseStatement(ElseStatementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterElseStatement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitElseStatement(org.einnovator.markup.sass.antlr.ScssParser.ElseStatementContext)
	 */
	@Override
	public void exitElseStatement(ElseStatementContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitElseStatement:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterConditions(org.einnovator.markup.sass.antlr.ScssParser.ConditionsContext)
	 */
	@Override
	public void enterConditions(ConditionsContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterConditions:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitConditions(org.einnovator.markup.sass.antlr.ScssParser.ConditionsContext)
	 */
	@Override
	public void exitConditions(ConditionsContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitConditions:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterCondition(org.einnovator.markup.sass.antlr.ScssParser.ConditionContext)
	 */
	@Override
	public void enterCondition(ConditionContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterCondition:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitCondition(org.einnovator.markup.sass.antlr.ScssParser.ConditionContext)
	 */
	@Override
	public void exitCondition(ConditionContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitCondition:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterVariableDeclaration(org.einnovator.markup.sass.antlr.ScssParser.VariableDeclarationContext)
	 */
	@Override
	public void enterVariableDeclaration(VariableDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterVariableDeclaration:" + ctx.getText());			
		}
		var = new StyleVariable();
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitVariableDeclaration(org.einnovator.markup.sass.antlr.ScssParser.VariableDeclarationContext)
	 */
	@Override
	public void exitVariableDeclaration(VariableDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitVariableDeclaration:" + ctx.getText());			
		}
		stylesheet.addVariable(var);
		var = null;
		expr = null;
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterForDeclaration(org.einnovator.markup.sass.antlr.ScssParser.ForDeclarationContext)
	 */
	@Override
	public void enterForDeclaration(ForDeclarationContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterForDeclaration:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitForDeclaration(org.einnovator.markup.sass.antlr.ScssParser.ForDeclarationContext)
	 */
	@Override
	public void exitForDeclaration(ForDeclarationContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitForDeclaration:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterFromNumber(org.einnovator.markup.sass.antlr.ScssParser.FromNumberContext)
	 */
	@Override
	public void enterFromNumber(FromNumberContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterFromNumber:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitFromNumber(org.einnovator.markup.sass.antlr.ScssParser.FromNumberContext)
	 */
	@Override
	public void exitFromNumber(FromNumberContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitFromNumber:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterThroughNumber(org.einnovator.markup.sass.antlr.ScssParser.ThroughNumberContext)
	 */
	@Override
	public void enterThroughNumber(ThroughNumberContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterThroughNumber:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitThroughNumber(org.einnovator.markup.sass.antlr.ScssParser.ThroughNumberContext)
	 */
	@Override
	public void exitThroughNumber(ThroughNumberContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitThroughNumber:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterWhileDeclaration(org.einnovator.markup.sass.antlr.ScssParser.WhileDeclarationContext)
	 */
	@Override
	public void enterWhileDeclaration(WhileDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterWhileDeclaration:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitWhileDeclaration(org.einnovator.markup.sass.antlr.ScssParser.WhileDeclarationContext)
	 */
	@Override
	public void exitWhileDeclaration(WhileDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitWhileDeclaration:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterEachDeclaration(org.einnovator.markup.sass.antlr.ScssParser.EachDeclarationContext)
	 */
	@Override
	public void enterEachDeclaration(EachDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterEachDeclaration:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitEachDeclaration(org.einnovator.markup.sass.antlr.ScssParser.EachDeclarationContext)
	 */
	@Override
	public void exitEachDeclaration(EachDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitEachDeclaration:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterEachValueList(org.einnovator.markup.sass.antlr.ScssParser.EachValueListContext)
	 */
	@Override
	public void enterEachValueList(EachValueListContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterEachValueList:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitEachValueList(org.einnovator.markup.sass.antlr.ScssParser.EachValueListContext)
	 */
	@Override
	public void exitEachValueList(EachValueListContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitEachValueList:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterIdentifierListOrMap(org.einnovator.markup.sass.antlr.ScssParser.IdentifierListOrMapContext)
	 */
	@Override
	public void enterIdentifierListOrMap(IdentifierListOrMapContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterIdentifierListOrMap:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitIdentifierListOrMap(org.einnovator.markup.sass.antlr.ScssParser.IdentifierListOrMapContext)
	 */
	@Override
	public void exitIdentifierListOrMap(IdentifierListOrMapContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitIdentifierListOrMap:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterIdentifierValue(org.einnovator.markup.sass.antlr.ScssParser.IdentifierValueContext)
	 */
	@Override
	public void enterIdentifierValue(IdentifierValueContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterIdentifierValue:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitIdentifierValue(org.einnovator.markup.sass.antlr.ScssParser.IdentifierValueContext)
	 */
	@Override
	public void exitIdentifierValue(IdentifierValueContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitIdentifierValue:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterImportDeclaration(org.einnovator.markup.sass.antlr.ScssParser.ImportDeclarationContext)
	 */
	@Override
	public void enterImportDeclaration(ImportDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterImportDeclaration:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitImportDeclaration(org.einnovator.markup.sass.antlr.ScssParser.ImportDeclarationContext)
	 */
	@Override
	public void exitImportDeclaration(ImportDeclarationContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitImportDeclaration:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterReferenceUrl(org.einnovator.markup.sass.antlr.ScssParser.ReferenceUrlContext)
	 */
	@Override
	public void enterReferenceUrl(ReferenceUrlContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterReferenceUrl:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitReferenceUrl(org.einnovator.markup.sass.antlr.ScssParser.ReferenceUrlContext)
	 */
	@Override
	public void exitReferenceUrl(ReferenceUrlContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitReferenceUrl:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterMediaTypes(org.einnovator.markup.sass.antlr.ScssParser.MediaTypesContext)
	 */
	@Override
	public void enterMediaTypes(MediaTypesContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterMediaTypes:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitMediaTypes(org.einnovator.markup.sass.antlr.ScssParser.MediaTypesContext)
	 */
	@Override
	public void exitMediaTypes(MediaTypesContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitMediaTypes:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterNested(org.einnovator.markup.sass.antlr.ScssParser.NestedContext)
	 */
	@Override
	public void enterNested(NestedContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterNested:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitNested(org.einnovator.markup.sass.antlr.ScssParser.NestedContext)
	 */
	@Override
	public void exitNested(NestedContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitNested:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterNest(org.einnovator.markup.sass.antlr.ScssParser.NestContext)
	 */
	@Override
	public void enterNest(NestContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterNest:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitNest(org.einnovator.markup.sass.antlr.ScssParser.NestContext)
	 */
	@Override
	public void exitNest(NestContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitNest:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterRuleset(org.einnovator.markup.sass.antlr.ScssParser.RulesetContext)
	 */
	@Override
	public void enterRuleset(RulesetContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterRuleset" + ctx.getText());			
		}
		StyleRule rule = new StyleRule(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		if (!rules.isEmpty()) {
			rules.peek().addRule(rule);
		} else  if (stylesheet!=null) {
			stylesheet.addStyleRule(rule);			
		}
		rules.push(rule);

	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitRuleset(org.einnovator.markup.sass.antlr.ScssParser.RulesetContext)
	 */
	@Override
	public void exitRuleset(RulesetContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitRuleset:" + ctx.getText());			
		}
		if (stylesheet!=null) {
			rules.pop();			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterBlock(org.einnovator.markup.sass.antlr.ScssParser.BlockContext)
	 */
	@Override
	public void enterBlock(BlockContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterBlock:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitBlock(org.einnovator.markup.sass.antlr.ScssParser.BlockContext)
	 */
	@Override
	public void exitBlock(BlockContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitBlock:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterSelectors(org.einnovator.markup.sass.antlr.ScssParser.SelectorsContext)
	 */
	@Override
	public void enterSelectors(SelectorsContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterSelectors:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitSelectors(org.einnovator.markup.sass.antlr.ScssParser.SelectorsContext)
	 */
	@Override
	public void exitSelectors(SelectorsContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitSelectors:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterSelector(org.einnovator.markup.sass.antlr.ScssParser.SelectorContext)
	 */
	@Override
	public void enterSelector(SelectorContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterSelector:" + ctx.getText());			
		}
		rules.peek().addSelector(ctx.getText());		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitSelector(org.einnovator.markup.sass.antlr.ScssParser.SelectorContext)
	 */
	@Override
	public void exitSelector(SelectorContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("exitSelector:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterSelectorPrefix(org.einnovator.markup.sass.antlr.ScssParser.SelectorPrefixContext)
	 */
	@Override
	public void enterSelectorPrefix(SelectorPrefixContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterSelectorPrefix:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitSelectorPrefix(org.einnovator.markup.sass.antlr.ScssParser.SelectorPrefixContext)
	 */
	@Override
	public void exitSelectorPrefix(SelectorPrefixContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitSelectorPrefix:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterElement(org.einnovator.markup.sass.antlr.ScssParser.ElementContext)
	 */
	@Override
	public void enterElement(ElementContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterElement:" + ctx.getText());			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitElement(org.einnovator.markup.sass.antlr.ScssParser.ElementContext)
	 */
	@Override
	public void exitElement(ElementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitElement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterPseudo(org.einnovator.markup.sass.antlr.ScssParser.PseudoContext)
	 */
	@Override
	public void enterPseudo(PseudoContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterPseudo:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitPseudo(org.einnovator.markup.sass.antlr.ScssParser.PseudoContext)
	 */
	@Override
	public void exitPseudo(PseudoContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitPseudo:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterAttrib(org.einnovator.markup.sass.antlr.ScssParser.AttribContext)
	 */
	@Override
	public void enterAttrib(AttribContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterAttrib:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitAttrib(org.einnovator.markup.sass.antlr.ScssParser.AttribContext)
	 */
	@Override
	public void exitAttrib(AttribContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitAttrib:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterAttribRelate(org.einnovator.markup.sass.antlr.ScssParser.AttribRelateContext)
	 */
	@Override
	public void enterAttribRelate(AttribRelateContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterAttribRelate:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitAttribRelate(org.einnovator.markup.sass.antlr.ScssParser.AttribRelateContext)
	 */
	@Override
	public void exitAttribRelate(AttribRelateContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitAttribRelate:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterIdentifier(org.einnovator.markup.sass.antlr.ScssParser.IdentifierContext)
	 */
	@Override
	public void enterIdentifier(IdentifierContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterIdentifier:" + ctx.getText());			
		}
		if (property!=null) {
			if (property.getName()==null) {
				property.setName(ctx.getText());				
			}
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitIdentifier(org.einnovator.markup.sass.antlr.ScssParser.IdentifierContext)
	 */
	@Override
	public void exitIdentifier(IdentifierContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitIdentifier:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterIdentifierPart(org.einnovator.markup.sass.antlr.ScssParser.IdentifierPartContext)
	 */
	@Override
	public void enterIdentifierPart(IdentifierPartContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterIdentifierPart:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitIdentifierPart(org.einnovator.markup.sass.antlr.ScssParser.IdentifierPartContext)
	 */
	@Override
	public void exitIdentifierPart(IdentifierPartContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitIdentifierPart:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterIdentifierVariableName(org.einnovator.markup.sass.antlr.ScssParser.IdentifierVariableNameContext)
	 */
	@Override
	public void enterIdentifierVariableName(IdentifierVariableNameContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterIdentifierVariableName:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitIdentifierVariableName(org.einnovator.markup.sass.antlr.ScssParser.IdentifierVariableNameContext)
	 */
	@Override
	public void exitIdentifierVariableName(IdentifierVariableNameContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitIdentifierVariableName:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterProperty(org.einnovator.markup.sass.antlr.ScssParser.PropertyContext)
	 */
	@Override
	public void enterProperty(PropertyContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterProperty:" + ctx.getText());			
		}
		
		property = new StyleProperty(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		rules.peek().addProperty(property);
		
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitProperty(org.einnovator.markup.sass.antlr.ScssParser.PropertyContext)
	 */
	@Override
	public void exitProperty(PropertyContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("entexitPropertyerParam:" + ctx.getText());			
		}
		property = null;		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterValues(org.einnovator.markup.sass.antlr.ScssParser.ValuesContext)
	 */
	@Override
	public void enterValues(ValuesContext ctx) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("enterValues:" + ctx.getText());			
		}
		String value = ctx.getText();
		if (var!=null) {
			var.setValue(value);
		} else if (property!=null) {
			property.setValue(value);			
		}

	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitValues(org.einnovator.markup.sass.antlr.ScssParser.ValuesContext)
	 */
	@Override
	public void exitValues(ValuesContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitValues:" + ctx.getText());			
		}
		if (expr!=null) {
			if (var!=null) {
				var.setExpr(expr);
			} else if (property!=null) {
				property.setExpr(expr);			
			}			
		}
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterUrl(org.einnovator.markup.sass.antlr.ScssParser.UrlContext)
	 */
	@Override
	public void enterUrl(UrlContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterUrl:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitUrl(org.einnovator.markup.sass.antlr.ScssParser.UrlContext)
	 */
	@Override
	public void exitUrl(UrlContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitUrl:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterMeasurement(org.einnovator.markup.sass.antlr.ScssParser.MeasurementContext)
	 */
	@Override
	public void enterMeasurement(MeasurementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterMeasurement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitMeasurement(org.einnovator.markup.sass.antlr.ScssParser.MeasurementContext)
	 */
	@Override
	public void exitMeasurement(MeasurementContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitMeasurement:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#enterFunctionCall(org.einnovator.markup.sass.antlr.ScssParser.FunctionCallContext)
	 */
	@Override
	public void enterFunctionCall(FunctionCallContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterFunctionCall:" + ctx.getText());			
		}
		
	}

	/* 
	 * @see org.einnovator.markup.sass.antlr.ScssParserListener#exitFunctionCall(org.einnovator.markup.sass.antlr.ScssParser.FunctionCallContext)
	 */
	@Override
	public void exitFunctionCall(FunctionCallContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("exitFunctionCall:" + ctx.getText());			
		}
		
	}

}
