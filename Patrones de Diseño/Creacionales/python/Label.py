class Label(Widget):
    """Label widget which can display text and bitmaps."""
    def __init__(self, master=None, cnf={}, **kw):
        """Construct a label widget with the parent MASTER.

        STANDARD OPTIONS

            activebackground, activeforeground, anchor,
            background, bitmap, borderwidth, cursor,
            disabledforeground, font, foreground,
            highlightbackground, highlightcolor,
            highlightthickness, image, justify,
            padx, pady, relief, takefocus, text,
            textvariable, underline, wraplength

        WIDGET-SPECIFIC OPTIONS

            height, state, width

        """
        Widget.__init__(self, master, 'label', cnf, kw)
