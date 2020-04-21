/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package tech.pegasys.besu.plugins.besubaseline;

import org.hyperledger.besu.plugin.BesuContext;
import org.hyperledger.besu.plugin.BesuPlugin;
import org.hyperledger.besu.plugin.data.PropagatedBlockContext;
import org.hyperledger.besu.plugin.data.Transaction;
import org.hyperledger.besu.plugin.services.BesuEvents;
import org.hyperledger.besu.plugin.services.MetricsSystem;
import org.hyperledger.besu.plugin.services.PicoCLIOptions;
import org.hyperledger.besu.plugin.services.metrics.Counter;
import org.hyperledger.besu.plugin.services.metrics.LabelledMetric;
import org.hyperledger.besu.plugin.services.metrics.MetricCategory;
import org.hyperledger.besu.plugin.services.metrics.MetricCategoryRegistry;

import java.util.Optional;

import com.google.auto.service.AutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine.Option;

// The AutoService annotation (when paired with the corresponding annotation processor) will
// automatically handle adding the relevant META-INF files so Besu will load this plugin.
@AutoService(BesuPlugin.class)
public class GasSpendingMetricsPlugin implements BesuPlugin {

  private static Logger LOG = LogManager.getLogger();

  private static String PLUGIN_NAME = "gas-spending-metrics";

  @Override
  public Optional<String> getName() {
    return Optional.of("Gas Spending Metrics");
  }

  private BesuContext context;

  @Override
  public void register(final BesuContext context) {
  }

  @Override
  public void start() {
  }

  @Override
  public void stop() {
  }

  //
  // CLI Options
  //

  // CLI names must be of the form "--plugin-<namespace>-...."
  @Option(names = "--plugin-gas-spending-metrics-prefix")
  public String metricPrefix = "besu_baseline_";

  private void createPicoCLIOptions(final PicoCLIOptions picoCLIOptions) {
    picoCLIOptions.addPicoCLIOptions(PLUGIN_NAME, this);
  }
