a.  Rules:
    1. spaces are skipped but used to tell variables, keywords, or identifiers
    2. if '<','>','!','=' tokens appear, they will be paired with '=' if it follows and made into 
        a seperate token, otherwise they are their own token
    3. tokens '+','-','*','/','%','.', ',' ,';','(',')','{','}','&','|' are always their own tokens
    4. if a digit appears, group digits together and allow for a decimal or 'l' to determine float and long types 
        respectively
    5. all keywords, variables, and identifiers must start with lowercase letters
    6. variables must start with lowercase, be 6-8 characters long, and may contain underscores
    7. Keywords --> while:'run', if:'given', else:'inst', start_file:'start', end_file;'stop',
        int_id:'num', float_id:'dec', long_id:'largo'
    8. If any combination of characters does not conform to these rules, they are assigned an UKNOWN token type
        and a lexeme error is thrown
        
b.  <stmt> --> <if_stmt> | <while_stmt> | <as_s> | <block> 
    <block> --> `{` { <stmt> } `}`
    <if_stmt> -->  `if``(`<bool_expr>`)` <stmt> [ `else` <stmt> ]
    <while_loop> -->  `while``(`<bool_expr>`)` <stmt> 
    <as_s>  --> [`id`] 'var' `=` {<expr>};
    <expr> --> <term> { (`+`|`-`) <term> }
    <term> --> <factor> { (`*`|`\`|`%`) <factor> }
    <factor> --> `id` | `int_lit` | `float_lit` | `(` <expr> `)`
    <bool_expr> --> <band> { `OR` <band> }
    <band> --> <beq> { `AND` <beq> }
    <beq> --> <brel> { (`!=`|`==`) <brel> }
    <brel> --> <bexpr> { (`<=`|`>=` | `<` | `>`) <bexpr> }
    <bexpr> --> <bterm> { (`+`|`-`) <bterm> }
    <bbterm> --> <bnot> { (`*`|`\`|`%`) <bnot> }
    <bnot> -> [!]<bfactor>
    <bfactor> --> `id` | `int_lit` | `float_lit` | `bool_lit` | `(` <bexpr> `)`
    
c.  yes, is a pairwise disjoint and contains no left hand recursion

g.  lexErr1.txt - 'int' should be 'num' for an interger identifier, 'world.24' does
    not follow the rule for variable names, 'else' should be 'inst' for the else
    statement in an if block, 'Float' should be 'dec' for a float identifier and 
    it shouldn't be capitalized, '5.7.8' does not follow the rule for float literals
    due to the extra dot

    SynErr2.txt - program needs to begin with 'start', '==' after world1 is not an
    assignment character, the braces after 'given' should be replaced with 
    parenthesis, missing boolean character in the 'if' block between 'world1' and 
    '3', there needs to be a semicolon after 'world1 = 3 + 5' to complete
    the assigment statement 

    
