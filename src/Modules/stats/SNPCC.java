/*
 * Copyright (c) 2016. EAGER-CLI Alexander Peltzer
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package Modules.stats;

import IO.Communicator;
import Modules.AModule;

/**
 * Created by peltzer on 25.07.14.
 */
public class SNPCC extends AModule {
    public SNPCC(Communicator c){ super(c);}

    @Override
    public void setParameters() {
        this.outputfile = this.inputfile;
        this.parameters = new String[]{"snpcc", this.inputfile.get(0), "/opt/snpcc/390KPos"};
    }

    @Override
    public String getOutputfolder() {
        return this.communicator.getGUI_resultspath()+"/10-GATKGenotyper";
    }


}